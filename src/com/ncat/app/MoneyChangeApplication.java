package com.ncat.app;

public class MoneyChangeApplication {

	public static boolean isPossible(int[] bucket, int money) {
        switch (money) {
            case 5: // add 5 in bucket
                bucket[0]++;
                return true;
            case 10: // add 10 in bucket but return 5
                if (bucket[0] >= 1) {
                    bucket[0]--;
                    bucket[1]++;
                    return true;
                }
                return false;
            case 20:
                if (bucket[0] >= 1 && bucket[1] >= 1) { // change: 5 + 10 = 15
                    bucket[0]--;
                    bucket[1]--;
                    return true;
                }
                if (bucket[0] >= 3) { // change = 5 + 5 + 5
                    bucket[0] -= 3;
                    return true;
                }
                return false;
            default:
                return false; // not possible
        }
    }

    public static void doSolution(int[] queue) {
        int n = queue.length;
        var result = new boolean[n];

        int[] bucket = new int[]{0, 0}; // 0 -> 5, 1 -> 10
        for (int i = 0; i < n; i++) {
            int money = queue[i];
            boolean possible = isPossible(bucket, money);
            result[i] = possible;
        }
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    
	public static void main(String[] args) {
		int[] queue = new int[args.length];
        for (int i = 0; i < args.length; i++)
        	queue[i] = Integer.parseInt(args[i]);

        doSolution(queue);
	}

}
