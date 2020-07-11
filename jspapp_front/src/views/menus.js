/**
 * 管理员菜单
 * @type {*[]}
 */

// 查看菜单列表
const menus = [
    {
        name: "首页",
        path: "/",
        icon: "ios-navigate"
    },
    // 系统管理
    {
        name: "系统管理",
        path: "set",
        icon: "ios-cog",
        children: [
            {
                icon: "md-contacts",
                name: "管理员",
                path: "/admin"
            },
            {
                icon: "md-contacts",
                name: "学生创建",
                path: "/admin/create"
            },
            {
                icon: "md-contacts",
                name: "学生管理",
                path: "/adminList"
            }
        ]
    }, {
        name: "账号管理",
        path: "account",
        icon: "ios-cog",
        children: [
            {
                icon: "md-contacts",
                name: "账号设置",
                path: "/setting"
            }
        ]
    }

];

export { menus };
