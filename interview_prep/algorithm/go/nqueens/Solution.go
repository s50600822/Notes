package main

func solveNQueens(n int) (ans [][]string) {
	col := make([]int, n)
	dg := make([]int, n<<1)
	udg := make([]int, n<<1)
	t := make([][]byte, n)
	for i := range t {
		t[i] = make([]byte, n)
		for j := range t[i] {
			t[i][j] = '.'
		}
	}
	var dfs func(int)
	dfs = func(i int) {
		if i == n {
			tmp := make([]string, n)
			for i := range tmp {
				tmp[i] = string(t[i])
			}
			ans = append(ans, tmp)
			return
		}
		for j := 0; j < n; j++ {
			if col[j]+dg[i+j]+udg[n-i+j] == 0 {
				col[j], dg[i+j], udg[n-i+j] = 1, 1, 1
				t[i][j] = 'Q'
				dfs(i + 1)
				t[i][j] = '.'
				col[j], dg[i+j], udg[n-i+j] = 0, 0, 0
			}
		}
	}
	dfs(0)
	return
}

/*
 * with 15x15 board
 *    time ./Solution
 *         ./Solution  5.51s user 0.16s system 106% cpu 5.312 total,
 * compare to
 *    time java -ea Solution
 *         java -ea Solution  0.02s user 0.01s system 92% cpu 0.035 total  0.76s user 0.04s system 238% cpu 0.334 total
 */
func main() {
	solveNQueens(15)
}
