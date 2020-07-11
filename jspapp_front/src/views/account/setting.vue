<template>
  <section v-if="adminAuth">
    <h2>基本信息</h2>
    <h5>我的账号： {{adminAuth.account}}</h5>
    <h5>我的姓名： {{adminAuth.username}}</h5>
    <h5>我的地址： {{adminAuth.adress?adminAuth.adress:"尚未填写地址"}}</h5>
    <h5>我的年龄： {{adminAuth.age?adminAuth.age:"尚未设置年龄"}}</h5>
    <h1 style="text-align: left;margin-top: 100px">
      <i-button type="primary" @click="modal1 = true">修改密码</i-button>
      <i-button type="warning" @click="modal2 = true">注销账号</i-button>
    </h1>

    <Modal v-model="modal1" title="修改信息" @on-ok="ok" @on-cancel="cancel">
      <h5>我的账号： {{adminAuth.account}}</h5>
      <h5>
        原用密码：
        <i-input v-model="oldPassword" placeholder="请输入密码" type="password" style="width: 300px"></i-input>
      </h5>
      <h5>
        新用密码：
        <i-input v-model="newPassword" placeholder="请输入密码" type="password" style="width: 300px"></i-input>
      </h5>
      <h5>
        确认密码：
        <i-input v-model="comPassword" placeholder="请输入密码" type="password" style="width: 300px"></i-input>
      </h5>
      <div slot="footer">
        <i-button type="primary" size="large" long @click="update">修改</i-button>
      </div>
    </Modal>
    <Modal v-model="modal2" title @on-ok="ok1" @on-cancel="cancel1">
      <p>
        <Icon type="android-warning" color="red"></Icon>是否注销此管理账号?
      </p>
    </Modal>
  </section>
</template>

<script>
import { mapState, mapActions } from "vuex";
import admin from "../../api/admin";
export default {
  components: {},

  data() {
    return {
      modal1: false,
      modal2: false,
      oldPassword: "",
      newPassword: "",
      comPassword: ""
    };
  },
  created() {},
  computed: {
    ...mapState({
      adminAuth: state => state.admin.adminAuth
    })
  },

  methods: {
    async update() {
      if (this.password == "" || this.password1 == "" || this.password2 == "") {
        this.$Message.error("密码不能为空");
      }
      if (this.password1 != this.password2) {
        this.$Message.error("新密码前后不相等");
      }
      try {
        let { data } = await admin.updatePwdById(this.adminAuth.id, {
          oldPassword: this.oldPassword,
          newPassword: this.newPassword,
          comPassword: this.comPassword
        });
        if (data.code == 0) {
          this.$Message.info("密码更新成功");
          this.modal1 = false;
        } else {
          this.$Message.error("请输入正确的密码");
        }
      } catch (e) {
        this.$Message.error("请输入正确的密码");
      }
    },
    ok() {
      //   this.$Message.info("点击了确定");
    },
    cancel() {},
    async ok1() {
      try {
        let { data } = await admin.delete(this.adminAuth.id);
        console.log(data);
        if (data.code == 0) {
          this.$router.push("/login");
        } else {
          this.$Message.error("注销失败");
        }
      } catch (e) {
        this.$Message.error("注销失败");
      }
    },
    cancel1() {
      this.$Message.info("点击了取消");
    }
  }
};
</script>

<style scoped>
h1 {
  font-weight: normal;
}
h5 {
  margin: 10px 0;
}
</style>
