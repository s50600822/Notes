def split_file(input_file, output_file):
    with open(input_file, 'r') as infile:
        data = infile.read().strip().split(',')

    lines = [','.join(data[i:i + 100]) for i in range(0, len(data), 100)]

    with open(output_file, 'w') as outfile:
        outfile.write(',\n'.join(lines))

# Call the function
split_file("i.txt", "output.txt")