This question came up in an Advanced Python Programming class:
* Does using a prime number modulus divisor when performing range reduction of keys onto a hash table reduce collisions compared to other divisors?  Are prime numbers the best modulus divisor for reducing collisions?

* hashtable_index_for_value = hash_function(value) % d

Here are some possible directions:
* The hash function itself is more important than the modulus divisor
  * If the hash_function produces evenly distributed hashes for all values, then there are no patterns or groupings for a non-prime divisor to exploit
* A modulus divisor that is farther from a power of 2 is better than a prime divisor closer to a power of 2
  * since data is represented in a computer as binary, a modulus divisor equivalent to 2^n would result in more collisions
