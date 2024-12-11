def count_primes(n):
    if n <= 2:
        return 0

    is_prime = [True] * n
    is_prime[0] = is_prime[1] = False

    for i in range(2, int(n**0.5) + 1):
        if is_prime[i]:
            for j in range(i * i, n, i):
                is_prime[j] = False

    return sum(is_prime)

def test_count_primes():
    assert count_primes(18) == 7
    assert count_primes(10) == 4
    assert count_primes(2) == 0
    assert count_primes(20) == 8
    print("All tests passed!")

def main():
    test_count_primes() 
    
if __name__ == "__main__":
    main()
