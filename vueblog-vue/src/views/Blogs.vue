<template>
    <div>
        <Header></Header>

        <div class="block">
            <el-timeline>
                <el-timeline-item :timestamp="blog.created" placement="top" v-for="blog in blogs">
                    <el-card>
                        <h4>
                            <router-link :to="{name: 'Detail', params: {blogId: blog.id}}">
                                {{blog.title}}
                            </router-link>
                        </h4>
                        <p>{{blog.description}}</p>
                    </el-card>
                </el-timeline-item>
            </el-timeline>

            <el-pagination
                    background
                    layout="prev, pager, next"
                    class="mpage"
                    :currentPage="currentPage"
                    :pageSize="pageSize"
                    :total="total"
                   @current-change=page
            >
            </el-pagination>
        </div>

    </div>
</template>

<script>
    import Header from '../components/Header'
    export default {
        name: "Blogs",
        components: {
            Header
        },
        data() {
            return{
                blogs: {},
                currentPage: 1,
                total: 0,
                pageSize: 2
            }
        },
        methods: {
            page(currentPage) {
                const _this = this
                _this.$axios.get("/blog/list?currentPage=" + currentPage).then(res => {
                    console.log(res)
                    _this.blogs = res.data.data.records
                    _this.currentPage = res.data.data.current
                    _this.total = res.data.data.total
                    _this.pageSize = res.data.data.size
                })
            }
        },
        created() {
            this.page(1)
        }
    }
</script>

<style scoped>
    .mpage {
        margin: 0 auto;
        text-align: center;
    }
</style>