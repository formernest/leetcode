
def fillItems(matrix: int[[]]):
    rows = len(matrix)
    cols = len(matrix[0])
    for i in range(rows):
        count = matrix[i].count(0)
        if count <= cols-2:
            fill(matrix, i, 1)
    for j in range(cols):
        count = matrix[:][j].count(0)
        if count <= rows-2:
            fill(matrix, j, 0)

def fill(matrix, index, 0):
    for i in range(len(matrix[0])):

















if __name__ == '__main__':
    pass
