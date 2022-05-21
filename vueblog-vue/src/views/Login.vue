<template>
    <div>
        <el-container>
            <el-header>
                <img class="mylogo" src="https://cdn.jsdelivr.net/gh/yub4by/picx-image-hosting@master/20211102/4.10n4zbutnwg0.jpg">
            </el-header>
            <el-main>
                <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                    <el-form-item label="用户名" prop="username">
                        <el-input v-model="ruleForm.username"></el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="password">
                        <el-input type="password" v-model="ruleForm.password"></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
                        <el-button @click="resetForm('ruleForm')">重置</el-button>
                    </el-form-item>
                </el-form>
            </el-main>
        </el-container>
    </div>
</template>


<script>
    export default {
        name: "Login",
        data() {
            return {
                ruleForm: {
                    username: 'markerhub',
                    password: '111111'
                },
                rules: {
                    username: [
                        { required: true, message: '请输入用户名', trigger: 'blur' },
                        { min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur' }
                    ],
                    password: [
                        { required: true, message: '请输入密码', trigger: 'change' }
                    ]
                }
            };
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        // alert('submit!');
                        const _this = this
                        // this.$axios.post("http://localhost:8081/login", this.ruleForm).then(res => {
                        this.$axios.post("/login", this.ruleForm).then(res => {
                            /*console.log(res)
                            console.log(res.data)
                            console.log(res.headers)*/
                            const jwt = res.headers['authorization']
                            const userInfo = res.data.data
                            /*console.log(jwt)
                            console.log(userInfo)*/
                            // 把数据共享出去
                            _this.$store.commit("SET_TOKEN", jwt) //store/index.js
                            _this.$store.commit("SET_USERINFO", userInfo)
                            // 获取
                            // console.log(_this.$store.getters.getUser)
                            // 跳转
                            _this.$router.push("/blogs")
                        })
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }
    }
</script>

<style scoped>
    .el-header, .el-footer {
        background-color: #B3C0D1;
        color: #333;
        text-align: center;
        line-height: 60px;
    }

    .el-aside {
        background-color: #D3DCE6;
        color: #333;
        text-align: center;
        line-height: 200px;
    }

    .el-main {
        /*background-color: #E9EEF3;*/
        color: #333;
        text-align: center;
        line-height: 160px;
    }

    body > .el-container {
        margin-bottom: 40px;
    }

    .el-container:nth-child(5) .el-aside,
    .el-container:nth-child(6) .el-aside {
        line-height: 260px;
    }

    .el-container:nth-child(7) .el-aside {
        line-height: 320px;
    }

    .mylogo{
        height: 70%;
        margin-top: 10px;
    }
    .demo-ruleForm{
        max-width: 500px;
        margin: 0 auto;
    }
</style>