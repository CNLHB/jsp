import axios from 'axios';

let util = {};

util.title = function (title) {
    title = title ? title + ' - 学生管理后台 ' : '学生管理后台';
    window.document.title = title;
};

const ajaxUrl = process.env.NODE_ENV === 'development' ? "http://192.168.31.164:8088/api" : "http://jsp.liaohuabiao.com/api"
// 'http://www.xquery.cn:3030/v1':
// 'http://localhost:3000/v1';
//   'http://localhost:3000' :
//   'http://www.xquery.cn:3030/v1';

util.ajax_url = ajaxUrl;

util.ajax = axios.create({
    baseURL: ajaxUrl,
    timeout: 30000
});
export default util;

