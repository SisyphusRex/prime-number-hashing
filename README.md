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

NOTE: I am implementing a Command Pattern Design menu and program flow for modularity.

compile:
    javac -d primenumberhashing/bin primenumberhashing/src/*.java

(if errors)
    javac -Xlint:unchecked  -d primenumberhashing/classfiles primenumberhashing/*.java


run:
    java -cp primenumberhashing/bin primenumberhashing.src.Bootstrap

