const routers = [
    {
        path: '/login',
        meta: {
            title: "登录",
            noAuth: true
        },
        // component: (resolve)=>require([...],resolve)
        component: (resolve) => require(['../views/login.vue'], resolve),
    },
    {
        path: '/',
        component(resolve) {
            require(['../views/layout.vue'], resolve);
        },
        children: [
            {
                //todo: 首页
                path: '/',
                name: 'index',
                meta: { module: "/", title: '首页' },
                component(resolve) {
                    require(['../views/index.vue'], resolve);
                }
            },

            //todo: 管理员
            {
                path: 'admin',
                name: 'admin',
                meta: { module: "/admin", group: "set", title: '管理员 - 列表' },
                component: (resolve) => require(['../views/admin/index.vue'], resolve),
            },
            {
                path: 'admin/create',
                name: 'create',
                meta: { edit: true, module: "/admin", group: "set", title: '学生 - 注册' },
                component: (resolve) => require(['../views/admin/create.vue'], resolve),
            },
            {
                path: 'admin/create/:id',
                name: 'create',
                meta: { edit: true, module: "/admin", group: "set", title: '学生 - 注册' },
                component: (resolve) => require(['../views/admin/create.vue'], resolve),
            },
            {
                path: 'adminlist',
                name: 'adminList',
                meta: { module: "/adminList", group: "set", title: '学生 - 列表' },
                component: (resolve) => require(['../views/admin/adminList.vue'], resolve),
            },
            {
                path: 'setting',
                name: 'setting',
                meta: { module: "/setting", group: "set", title: '账号 - 设置' },
                component: (resolve) => require(['../views/account/setting.vue'], resolve),
            },
            {
                //todo: 404
                path: '/403',
                name: '403',
                meta: { module: "/", title: '403 - 权限不足' },
                component(resolve) {
                    require(['../views/403.vue'], resolve);
                }
            },
            {
                //todo: 404
                path: '*',
                name: '404',
                meta: { module: "/", title: '404 - 页面不存在' },
                component(resolve) {
                    require(['../views/404.vue'], resolve);
                }
            }
        ]
    }
];

export default routers;
