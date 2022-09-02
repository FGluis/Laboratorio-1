

const fs = require('fs');
const {parse} = require("csv-parse")

fs.createReadStream("Datos1.csv")
    .pipe(parse({delimiter: ",", from_line: 2}))
    .on("data", function(row) {
        console.log(row);
    })


        