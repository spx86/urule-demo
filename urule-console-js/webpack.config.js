/**
 * Created by Jacky.Gao on 2018-04-23.
 * Base on Webpack4
 */
const path=require('path');
module.exports={
    mode:'development',
    entry: {
        frame:'./src/frame/index.jsx',
        variableEditor:'./src/variable/index.jsx',
        constantEditor:'./src/constant/index.jsx',
        parameterEditor:'./src/parameter/index.jsx',
        actionEditor:'./src/action/index.jsx',
        packageEditor:'./src/package/index.jsx',
        flowDesigner:'./src/flow/index.jsx',
        ruleSetEditor:'./src/editor/urule/index.jsx',
        decisionTableEditor:'./src/editor/decisiontable/index.jsx',
        scriptDecisionTableEditor:'./src/editor/scriptdecisiontable/index.jsx',
        decisionTreeEditor:'./src/editor/decisiontree/index.jsx',
        clientConfigEditor:'./src/client/index.jsx',
        ulEditor:'./src/editor/ul/index.jsx',
        scoreCardTable:'./src/scorecard/index.jsx',
        permissionConfigEditor:'./src/permission/index.jsx'
    },
    output:{
        //path:path.resolve('../urule-console/src/main/resources/urule-asserts/js'),
        path:path.resolve('./website/js'),
        filename:'[name].bundle.js'
    },
    module:{
        rules:[
            {
                test: /\.(jsx|js)?$/,
                exclude: /node_modules/,
                loader: "babel-loader",
                options:{
                    "presets": [
                        "react","env"
                    ]
                }
            },
            {
                test:/\.css$/,
                use: [{ loader: 'style-loader' }, { loader: 'css-loader' }]
            },
            {
                test: /\.(eot|woff|woff2|ttf|svg|png|jpg)$/,
                use: [
                    {
                        loader: 'url-loader',
                        options: {
                            limit: 10000000
                        }
                    }
                ]
            }
        ]
    }
};