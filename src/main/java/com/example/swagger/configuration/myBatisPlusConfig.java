package com.example.swagger.configuration;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.extension.plugins.SqlExplainInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @类描述:my
 * @创建人:xiejs
 * @创建时间:2020-5-19
 */
@Configuration
public class myBatisPlusConfig {

    //分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        // paginationInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        // paginationInterceptor.setLimit(500);
        // 开启 count 的 join 优化,只针对部分 left join
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize());
        return paginationInterceptor;
    }

    //
    @Bean
    public SqlExplainInterceptor sqlExplainInterceptor(){

        SqlExplainInterceptor sqlExplainInterceptor=new SqlExplainInterceptor();

        /*List<ISqlInjector> list=new ArrayList<>();
        sqlExplainInterceptor.setSqlParserList(list);*/


        return new SqlExplainInterceptor();
    }

    //性能分析插件
    @Bean
    public PerformanceInterceptor performanceInterceptor(){
        PerformanceInterceptor performanceInterceptor=new PerformanceInterceptor();
        performanceInterceptor.setMaxTime(100)
        ;
        return performanceInterceptor;
    }

    //乐观锁插件
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }


}
