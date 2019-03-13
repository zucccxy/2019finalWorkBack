package org.hzqisheng.backTask;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.hzqisheng.service.GithubService;
import org.lis_entity.GithubProject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.util.OkHttpUtil;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Author thlnkpad
 * @Date 2019/1/16 10:06
 **/
@Component
@Slf4j
@Transactional
public class Task {
    @Resource
    GithubService githubService;

    OkHttpUtil okHttpUtil;

    /**
     * 两分钟调用一次获取github项目数据
     * @throws Exception
     */
    @Scheduled(cron = "0 */1 * * * *")
    public void getGithubProject() throws Exception{
          try{
              Map<String,String> query=new HashMap<>();
              query.put("q","language:");
              query.put("sort","stars");
              query.put("per_page","10");
            String result=okHttpUtil.get("https://api.github.com/search/repositories",query);
            log.info("后台获取github项目------------------------------------");
//            log.info(result);
              ObjectMapper m=new ObjectMapper();
              JsonNode rootNode=m.readTree(result);
              JsonNode itemsNode=rootNode.get("items");
              Iterator<JsonNode> items=itemsNode.iterator();
              List<GithubProject> githubProjectList=new ArrayList<>();
              while(items.hasNext()){
                  GithubProject githubProject=new GithubProject();
               JsonNode item=items.next();
//               log.info(item.get("name").textValue()+ "-"
//                       +item.get("html_url").textValue()+"-"
//                       +item.get("description").textValue()+"-"
//                       +item.get("language").textValue()+"-"
//                       +item.get("forks").longValue()+"-"
//                       +item.get("stargazers_count").longValue()+"-"
//                       +item.get("open_issues").longValue()+"-");
               JsonNode ownerNode=item.get("owner");
//               log.info(ownerNode.get("login").textValue()+"-"
//                        +ownerNode.get("avatar_url").textValue());
               String fullName=item.get("full_name").textValue();
//               String readmeContentResult=okHttpUtil.get("https://api.github.com/repos/"+fullName+"/readme",null);
//               ObjectMapper m1=new ObjectMapper();
//               JsonNode readmeNode=m1.readTree(readmeContentResult);
                  githubProject.setProjectName(item.get("name").textValue());
                  githubProject.setProjectAddress(item.get("html_url").textValue());
                  githubProject.setProjectDes(item.get("description").textValue());
                  githubProject.setProjectLanguage(item.get("language").textValue());
                  githubProject.setProjectFork(item.get("forks").longValue());
                  githubProject.setProjectStar(item.get("stargazers_count").longValue());
                  githubProject.setProjectIssue(item.get("open_issues").longValue());
                  githubProject.setProjectAuthor(ownerNode.get("login").textValue());
                  githubProject.setProjectAvatarurl(ownerNode.get("avatar_url").textValue());
//                  githubProject.setProjectReadme(readmeNode.get("content").textValue());
                  githubProjectList.add(githubProject);
              }
              if(githubService.isEmptyGithubProject()){
                  githubService.addGithubProject(githubProjectList);
              }else{
                  githubService.deleteGithubProject();
                  githubService.addGithubProject(githubProjectList);
              }
              log.info("后台获取github项目并存入数据库成功------------------------------------");
          }catch (Exception e){
              log.error(e+"后台获取github项目并存入数据库失败------------------------------------");
          }
    }

}
