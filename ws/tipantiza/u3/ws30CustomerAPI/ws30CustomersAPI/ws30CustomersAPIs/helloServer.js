const http = require('node:http');

const hostname = '127.0.0.1';
const port = 5015;

const server = http.createServer((req, res) => {
    res.statusCode = 200;
    res.setHeader('Content-Type', 'text/html'); 
    res.end('Hello, <b>Web Developers!</b> from <i>Alexander Tipantiza</i>');
});

server.listen(port, hostname, () => {
    console.log(`Alexander's Server running at http://${hostname}:${port}/`); 
});