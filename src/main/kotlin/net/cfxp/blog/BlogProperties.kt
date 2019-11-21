package net.cfxp.blog

data class BlogProperties(var title: String, val banner: Banner){
    data class Banner(val title: String? = null, val content: String)
}