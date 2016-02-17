module.exports = {
    entry: {
    	'giui':["./scripts/giui/giui.resource.js",
    	        "./scripts/giui/giui.plist.js"]
    },
    output: {
        path: __dirname+'/scripts/lib',
        filename: "[name].min.js"
    },
    module: {
        loaders: [
            { test: /\.css$/,exclude: /(node_modules|bower_components)/, loader: "style!css" },
            { test: /\.jsx?$/,exclude: /(node_modules|bower_components)/,loader: 'jsx-loader?harmony'},
            { test: /\.less$/, exclude: /(node_modules|bower_components)/,loader: "style!css!less" }
        ]
    }
};