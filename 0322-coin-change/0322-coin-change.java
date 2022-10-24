	class Solution {
		public int coinChange (int[] coins, int amount) {
			int[] mem = new int[amount+1];
            for(int i=0; i<mem.length; i++)
                mem[i] = -1;
            mem[0] = 0;
            for(int coin: coins){
                if(coin <= amount)
                    mem[coin] = 1;
            }
            int numOfCoins = dp(coins, mem, amount);
            return numOfCoins == Integer.MAX_VALUE? -1: numOfCoins;
		}
        private int dp(int[] coins, int[] mem, int amount){
            if(mem[amount] != -1)
                return mem[amount];
            mem[amount] = Integer.MAX_VALUE;
            for(int coin: coins){
                if(coin <= amount){
                    mem[amount] = Math.min(mem[amount], dp(coins, mem, amount-coin));
                }
            }
            if(mem[amount] != Integer.MAX_VALUE)
                mem[amount]++;
            return mem[amount];
        }
	}