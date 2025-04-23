const base = {
    get() {
        return {
            url : "http://localhost:8080/wangshangqingjiaxitong/",
            name: "wangshangqingjiaxitong",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/wangshangqingjiaxitong/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "学生网上请假系统"
        } 
    }
}
export default base
