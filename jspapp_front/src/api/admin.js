import fetch from './fetch';

export default {
    // 登录
    login(params) {

        // params.account = params.account
        // console.log(fetch.post('user/login', params).then(res => { console.log(res) }))
        return fetch.post('user/login', params)

    },
    register(params) {
        let data = {
            account: params.account,
            roleId: 3,
            username: params.account,
            password: params.password,
        }
        console.log(data)
        return fetch.post('user/register', data)
    },

    // 验证管理员token
    auth(params) {
        return fetch.get('/admin/auth', params)
    },
    byId(id) {
        return fetch.Util.ajax({
            method: 'get',
            url: "/user/" + id
        })
    },
    create(data) {
        data.roleId = 1
        return fetch.Util.ajax({
            method: 'post',
            url: "/user/register",
            data
        })
    },
    updateById(data) {
        return fetch.Util.ajax({
            method: 'put',
            url: "/user",
            data
        })
    },
    updatePwdById(id, data) {
        return fetch.putParm("/user/" + id,
            data
        )
    },
    list(root, pageNum, pageSize) {
        return fetch.Util.ajax({
            method: 'get',
            url: "/user/list",
            params: {
                type: root,
                page: pageNum,
                rows: pageSize
            }
        })
    },
    delete(id) {
        return fetch.Util.ajax({
            method: 'delete',
            url: "/user/" + id
        })
    }

}
