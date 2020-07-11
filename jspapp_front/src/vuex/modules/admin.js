import admin from '../../api/admin'
import * as types from '../mutation-types'

const state = {
    adminAuth: {
        account: "2017117128",
        id: 1,
        role: 'root',
        usernmae: "Seven"

    },
    list: []
}

const mutations = {
    SET_USER_INFO(state, data) {
        state.adminAuth = data
    },
    SET_ADMIN_LIST(state, data) {
        state.list = data
    },

}

const actions = {
    // 管理员登录
    login({ state, commit }, params) {
        return admin.login(params).then(res => {
            let data = res.data
            localStorage.setItem("uInfo", JSON.stringify(data))
            commit('SET_USER_INFO', data)

        })
    },
    setUInfo({ state, commit }, data) {
        commit('SET_USER_INFO', data)
    },
    register(params) {
        return admin.register(params).then(res => {
            return res
        })
    },
    // 获取当前管理员信息
    async auth({ state, commit }, params) {
        const res = await admin.auth(params);
        commit('SET_USER_INFO', res.data.data);
        return res;
    },
    async adminList({ state, commit }, data) {
        // const res = await admin.list("root"); 
        commit('SET_ADMIN_LIST', data);
    },
    async deleteAdmin({ state, commit }, id) {
        const res = await admin.delete(id);
    },
}

export default {
    namespaced: true,
    state,
    actions,
    mutations
}
