def coin_change(coins, amount):
    memo = {}

    def dp(rem):
        if rem < 0:  
            return float('inf') 
        if rem == 0:  
            return 0  
        if rem in memo:  
            return memo[rem]
        memo[rem] = min(1 + dp(rem - coin) for coin in coins)
        return memo[rem]

    result = dp(amount)
    return result if result != float('inf') else -1

def test_coin_change():
    assert coin_change([1, 2, 5], 11) == 3  
    assert coin_change([2], 3) == -1       
    assert coin_change([1], 0) == 0         
    assert coin_change([1], 2) == 2        
    assert coin_change([186, 419, 83, 408], 6249) == 20  
    print("All tests passed!")

def main():
    test_coin_change()

if __name__ == "__main__":
    main()
