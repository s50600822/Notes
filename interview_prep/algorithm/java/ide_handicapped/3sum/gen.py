def generate_list(n):
    num_list = list(range(-n, n + 1))
    return num_list

def main():
    n = int(input("Enter a value for n: "))
    result = generate_list(n)
    print(result)

if __name__ == "__main__":
    main()