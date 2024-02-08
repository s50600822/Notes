### References

- [Reddit - Node 17 currently breaks most Webpack](https://www.reddit.com/r/webdev/comments/qd14bm/node_17_currently_breaks_most_webpack/)
- [Webpack Hashed Module IDs Plugin](https://webpack.js.org/plugins/hashed-module-ids-plugin/)
- [Angular CLI GitHub Issue #1656](https://github.com/angular/angular-cli/issues/1656)
- [Stack Overflow - Error Message: error:0308010C:digital envelope routines:unsupported](https://stackoverflow.com/questions/69692842/error-message-error0308010cdigital-envelope-routinesunsupported)
- [Node.js Blog - OpenSSL November 2022 Vulnerability](https://nodejs.org/en/blog/vulnerability/openssl-november-2022)
- [Node.js GitHub Pull Request #40478](https://github.com/nodejs/node/pull/40478)
- [Node.js GitHub Issue #40455](https://github.com/nodejs/node/issues/40455)
- [Webpack.js.org config](https://github.com/webpack/webpack.js.org/commit/5a81c718d470cd4e82f177a5bd099164f4c6f7e9#diff-154021c8c1ce914c5be753b5667e4e615d0edfcb0874240c4fbf72a6424c7e65)


### Webpack


`webpack.config.js`
```javascript

module.exports = {
    output: {
        //https://webpack.js.org/configuration/output/#outputhashdigest
        hashFunction: 'sha256'
    },
};
```
OR xxhash64 as default by:

`webpack.config.js`
```javascript
module.exports = {
    experiments: {
        futureDefaults: true,
    },
};
```