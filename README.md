This question came up in an Advanced Python Programming class:
* Does using a prime number modulus divisor when performing range reduction of keys onto a hash table reduce collisions compared to other divisors?  Are prime numbers the best modulus divisor for reducing collisions?

* hashtable_index_for_value = hash_function(value) % d

Here are some possible directions:
* The hash function itself is more important than the modulus divisor
  * If the hash_function produces evenly distributed hashes for all values, then there are no patterns or groupings for a non-prime divisor to exploit
* A modulus divisor that is farther from a power of 2 is better than a prime divisor closer to a power of 2
  * since data is represented in a computer as binary, a modulus divisor equivalent to 2^n would result in more collisions
  * i think this only matters if the number of hashes exceeds the buckets in the array
  * NOTE: A modulus divisor equal to 2^n should be avoided
   * if the hash function has a tendency to produce more hashes with the same bits below 2^n, then that tendency will be repeated in the hashtable assignments

I've found conflicting responses on StackOverflow and other resources.  I cannot find a formal proof to reference.  I plan on writing a program that evaluates collisions with three variables:
1. hashes of keys (to create patterns indicative of poor hashing)
2. number of keys (probability distribution is more accurate the more data is used)
3. size of array (prime, 2^n, # of keys, furthest from 2^n (prime vs not prime))

11/15/2024
* I've thought more about what a hash table is.  It is a data structure that maps keys to values.  In practice, an attribute of an object is considered the key and the hashtable storing structure is an array.  The key is hashed by scrambling the bits so that they are (hopefully!) evenly distributed over the keyspace (number of bits in a hashed key).  Then the hashed key is range reduced to an index that is within the size of the array.
* For my expirement, we will use the following definitions:
1. HashTable: Associative array, hashed keys range reduced to array index
2. Hash function: function to scramble bits of a key over keyspace
3. Key: attribute of a piece of data used to identify it; thing to be hashed
4. Range Reduction: function to reduce hash to within size of hashtable
5. Hash: scrambled key
6. RangeReducedHash: key that has been hashed and range reduced.
7. Coprime: integers with no common factors other than 1

With these definitions, we can approach the problem.  Does using a prime number modulo for range reduction reduce collisions inside the hashtable?  My theory is that the modulo should not share factors with any constants of the hash function.  Constants within the hashing function can produce patterns in the hashes.  If the modulo shares factors with the hashing constants, then the intrinisc patterns of the hashes can be reproduced by the range reduction function and cause uneven distribution of keys to buckets in the hashtable.  If the modulo is prime, it has no factors besides 1 and itself to taint the range reduction.

Collisions can be avoided using a perfect hash function, but all of the keys must be known prior to creating the perfect hash function.  If we do not know all of the keys, or if they will change over time, we can not implement a perfect hash function.  In our imperfect hash function, which can produce collisions, we want to reduce collisions as much as possible.  In essence, if we know the hash function will produce collisions, let us evenly distribute those collisions over the hashtable.

My custom hashtable will handle collisions with separate chaining.  It will be a fixed length array of linked lists.  The length will equal the chosen modulo.  The getBucketIndex will find the bucket of a key.  It will hash the key and then range reduce it, producing the bucket index.

NOTE: I am implementing a Command Pattern Design menu and program flow for modularity.

Results:
1. Mod m forms a set {0, 1, 2...m-1}
2. A member without a modular multiplicative inverse breaks down the operations of the set
    * Any multiple of a number without a modular multiplicative inverse can only be reduced by mod m to a multiple of that number
    * all factors of the modulo m do not have modular multiplicative inverses
3. If the set of Keys that is being hashed contains a higher concentration of these multiples than the modulus set then there will be uneven distribution of the keys over the hash table
    * these multiples can be identified by having common factors with the modulo
4.  Sets formed by mod m where m is a prime number form fields
    * All members of fields have a modular multiplicative inverse
    * prime numbers have no factors besides 1 and themselves
5.  Thus, Prime Number modulos reduce uneven distribution.

What does this program do?
* This program creates hashtables from a predetermined set of well distributed keys using hash function parameters that can be changed by the user.  It prints the hash tables and contents to the terminal for viewing.
* The user can change:
    1. The modulo
    2. The hash constant
        * The hash constant biases the well distributed key set
        * This biased is accomplished by multiplying every member of the key set by the constant
    3. Hash pattern
        * this concatenates a string of characters (each an integer) to the end of a hashed key before range reduction
        * these patterns allow the user to demonstrate why modulo m where m is a power of 2 or 10 can produce poor distribution

Test it yourself:
1. Go to the hashtable parameters menu
2. Modify the modulo to be a number
3. Modify the hash constant to be a number
4. Load the keys and print
5. If the modulo and the hash constant share a factor, then the distribution of keys in the buckets will be poor
6. If the modulo and the hash constant share no factors, then the distribution of keys will be good

compile:
    javac -d primenumberhashing/bin primenumberhashing/src/*.java

(if errors)
    javac -Xlint:unchecked  -d primenumberhashing/bin primenumberhashing/src/*.java


run:
    java -cp primenumberhashing/bin primenumberhashing.src.Bootstrap

