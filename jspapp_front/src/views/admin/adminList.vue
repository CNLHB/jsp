<template>
  <section class="listMain">
    <!-- admin.list       v-if="user"-->
    <Button
      v-if="false"
      type="primary"
      @click="toPathLink('/admin/create')"
      icon="md-add"
      style="margin-bottom: 16px;"
    >新增管理员</Button>
    <Table border :columns="columns" :data="list">
      <template slot-scope="{ row }" slot="name">
        <strong>{{ row.name }}</strong>
      </template>
      <template slot-scope="{ row }" slot="action">
        <Button type="primary" size="small" style="margin-right: 5px" @click="update(row.id)">编辑</Button>
        <Button type="error" size="small" @click="destroy(row.id)">删除</Button>
      </template>
    </Table>
    <section class="page">
      <Page
        :total="page.total"
        :page-size="page.per_page"
        :current="page.current_page"
        show-total
        @on-change="handlePage"
      ></Page>
    </section>
  </section>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";
import list from "../../api/admin";
import admin from "../../api/admin";
export default {
  components: {},
  data() {
    return {
      page: {
        count: 0,
        current_page: 1,
        per_page: 10,
        total: 0
      },
      list: [],
      columns: [
        {
          title: "ID",
          key: "id",
          width: 80,
          align: "center"
        },
        {
          title: "学生账号",
          key: "account",
          align: "center"
        },
        {
          title: "学生姓名",
          key: "username",
          align: "center"
        },
        // {
        //   title: "学生密码",
        //   key: "password",
        //   align: "center"
        // },
        {
          title: "学生住址",
          key: "adress",
          align: "center"
        },
        {
          title: "学生年龄",
          key: "age",
          align: "center"
        },
        {
          title: "Action",
          slot: "action",
          width: 150,
          align: "center"
        }
      ]
    };
  },
  async created() {
    this._getAdminList();
  },
  computed: {
    ...mapState(["admin"])
  },

  methods: {
    ...mapActions({
      getList: "admin/adminList",
      deleteAdmin: "admin/deleteAdmin"
    }),
    ...mapMutations({}),
    // 删除
    destroy(id) {
      var slef = this;
      this.$Modal.confirm({
        title: "提示",
        content: "<p>确定删除此学生吗？</p>",
        loading: true,
        onOk: async () => {
          try {
            await this.deleteAdmin(id);
            this.$Message.success("删除成功");
            this._getAdminList();
          } catch (e) {
            this.$Message.error(e);
          } finally {
            this.$Modal.remove();
          }
        },
        onCancel: () => {
          this.$Message.warning("取消！");
        }
      });
    },
    update(id) {
      this.$router.push(`/admin/create/${id}`);
    },
    toPathLink(path) {
      this.$router.push(path);
    },
    // 切换分页
    handlePage(page) {
      this.currentPage = page;
      this._getAdminList();
    },
    async _getAdminList() {
      //获取管理员列表
      let { data } = await admin.list("root", this.page.current_page, 10);
      this.page = {
        count: data.total,
        current_page: data.page,
        total: data.total,
        per_page: 10
      };
      let adminList = data.items.map(item => {
        return {
          id: item.id,
          username: item.username,
          account: item.account,
          //   password: item.password,
          adress: item.adress,
          age: item.age
        };
      });
      this.list = adminList;
    }
  }
};
</script>

<style scoped>
.page {
  padding: 32px 0;
  text-align: center;
}
h1 {
  font-weight: normal;
}
.listMain {
  min-width: 700px;
}
</style>
