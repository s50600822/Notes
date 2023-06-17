"""
https://www.hackerrank.com/challenges/magic-square-forming/problem


there is a rule to calculate the magic constant for a magic square of any size. The magic constant is determined by the formula:

Magic Constant = (n * (n^2 + 1)) / 2

where 'n' is the number of rows (or columns) in the magic square.

For example:

For a 3x3 magic square, n = 3, so the magic constant is (3 * (3^2 + 1)) / 2 = 15.
For a 4x4 magic square, n = 4, so the magic constant is (4 * (4^2 + 1)) / 2 = 34.
For a 5x5 magic square, n = 5, so the magic constant is (5 * (5^2 + 1)) / 2 = 65.
And so on.
The magic constant represents the target sum that all rows, columns, and diagonals of the magic square should add up to.

    Number of magic square are limited:
    magic_squares = [
        [[8, 1, 6], [3, 5, 7], [4, 9, 2]],
        [[6, 1, 8], [7, 5, 3], [2, 9, 4]],
        [[4, 9, 2], [3, 5, 7], [8, 1, 6]],
        [[2, 9, 4], [7, 5, 3], [6, 1, 8]],
        [[8, 3, 4], [1, 5, 9], [6, 7, 2]],
        [[4, 3, 8], [9, 5, 1], [2, 7, 6]],
        [[6, 7, 2], [1, 5, 9], [8, 3, 4]],
        [[2, 7, 6], [9, 5, 1], [4, 3, 8]]
    ]

"""
actual_magic_squares = [
        [[8, 1, 6], [3, 5, 7], [4, 9, 2]],
        [[6, 1, 8], [7, 5, 3], [2, 9, 4]],
        [[4, 9, 2], [3, 5, 7], [8, 1, 6]],
        [[2, 9, 4], [7, 5, 3], [6, 1, 8]],
        [[8, 3, 4], [1, 5, 9], [6, 7, 2]],
        [[4, 3, 8], [9, 5, 1], [2, 7, 6]],
        [[6, 7, 2], [1, 5, 9], [8, 3, 4]],
        [[2, 7, 6], [9, 5, 1], [4, 3, 8]]
    ]

def subtract_matrices(matrix1, matrix2):
  result = []
  for i in range(len(matrix1)):
    row = []
    for j in range(len(matrix1[0])):
      row.append(matrix1[i][j] - matrix2[i][j])
    result.append(row)
  return result
def sum_matrix(matrix):
  sum = 0
  for row in matrix:
    for element in row:
      sum += abs(element)
  return sum

def magic_square33(matrix):
    min = 999999999
    for candidate in actual_magic_squares:
      diff = sum_matrix(subtract_matrices(candidate, matrix))
      #print("{} {} {}\n".format(candidate, matrix, diff))
      if min > diff:
        min = diff
    return min


if __name__ == "__main__":
  main()