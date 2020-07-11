<template>
  <section>
    <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="100">
      <FormItem label="学生账号" prop="account">
        <Input v-model="formValidate.account" placeholder="学生账号" />
      </FormItem>
      <FormItem label="学生密码" prop="password">
        <Input v-model="formValidate.password" placeholder="学生密码" />
      </FormItem>
      <!-- <FormItem label="确认密码" prop="passWord1">
        <Input v-model="formValidate.key" placeholder="确认密码" />
      </FormItem>-->
      <FormItem label="学生姓名" prop="username">
        <Input v-model="formValidate.username" placeholder="学生姓名" />
      </FormItem>
      <FormItem label="学生地址" prop="adress">
        <Input v-model="formValidate.adress" placeholder="学生地址" />
      </FormItem>
      <FormItem label="学生年龄" prop="age">
        <Input v-model="formValidate.age" placeholder="学生年龄" />
      </FormItem>
      <FormItem>
        <Button @click="handleReset('formValidate')">重置</Button>
        <Button type="primary" @click="handleSubmit('formValidate')" style="margin-left: 8px">提交</Button>
      </FormItem>
    </Form>
  </section>
</template>
<script>
import { mapActions } from "vuex";
import admin from "../../api/admin";
export default {
  data() {
    return {
      id: this.$route.params.id,
      detail: null,
      formValidate: {
        account: "",
        password: "",
        username: "",
        adress: "",
        age: ""
      },
      ruleValidate: {
        account: [
          { required: true, message: "学生账号不能为空", trigger: "blur" }
        ],
        password: [
          { required: true, message: "学生密码不能为空", trigger: "blur" }
        ],
        username: [
          { required: true, message: "学生姓名不能为空", trigger: "blur" }
        ],
        adress: [
          { required: false, message: "学生姓名不能为空", trigger: "blur" }
        ],
        age: [{ required: false, message: "学生姓名不能为空", trigger: "blur" }]
      }
    };
  },

  async created() {
    if (this.$route.params.id == null) {
      return;
    }
    this.getList(this.$route.params.id);
  },
  methods: {
    async getList(id) {
      let { data } = await admin.byId(id);
      this.formValidate = {
        id: data.id,
        username: data.username,
        account: data.account,
        password: data.password,
        adress: data.adress,
        age: data.age
      };
    },
    // 创建
    async _createCategory() {
      if (this.id == null) {
        try {
          console.log(this.formValidate);
          await admin.create(this.formValidate);
          this.$Message.success("创建成功!");
          this.$router.push("/adminList");
        } catch (e) {}
      } else {
        this.formValidate.id = this.id;
        try {
          console.log(this.formValidate);
          await admin.updateById(this.formValidate);
          this.$Message.success("更新成功!");
          this.$router.push("/adminList");
        } catch (e) {}
      }
    },
    // 提交
    handleSubmit(name) {
      this.$refs[name].validate(valid => {
        if (valid) {
          this._createCategory();
        } else {
          this.$Message.error("请完成表单!");
        }
      });
    },
    handleReset(name) {
      this.$refs[name].resetFields();
    }
  }
};
</script>
