const crypto = require('crypto');

function generateHash(data, algo) {
    const hash = crypto.createHash(algo);
    hash.update(data);
    const hashedData = hash.digest('hex');

    return hashedData;
}

const testData = 'Hello, World!';
const hashedData = generateHash(testData, "md4");//"md5", "sha256", "sha512" ... are fine.

console.log('Original Data:', testData);
console.log('Hash:', hashedData);
