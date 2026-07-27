const http = require('node:http');

const hostname = '127.0.0.1';
const port = 5013;

const server = http.createServer((req, res) => {
    res.statusCode = 200;
    res.setHeader('Content-Type', 'text/html'); // Changed to 'text/html' for HTML content
    res.end('Hello, <b>Web Developers!</b> from <i>Joel Sanchez</i>');
});

server.listen(port, hostname, () => {
    console.log(`Sanchez's Server running at http://${hostname}:${port}/`); // Fixed template literal and escaped apostrophe
});