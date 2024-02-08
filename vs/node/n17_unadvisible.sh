NODE_VERSION=v17.0.0

source /Users/hoaphan/.nvm/nvm.sh
nvm install $NODE_VERSION
nvm use $NODE_VERSION

node --openssl-legacy-provider hash.js