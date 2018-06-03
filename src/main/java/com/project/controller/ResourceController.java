package com.project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.model.dto.PoiDomesticEntity;
import com.project.model.dto.PoiOverseasEntity;
import com.project.service.ResourceService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/get")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @RequestMapping("/img/**")
    public void geImage(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //FIXME 代码需要优化
        String path = request.getServletPath().substring("/get/img".length());
        File file = new File(path);
        byte[] bytes = new byte[(int)file.length()];
        IOUtils.read(new FileInputStream(file),bytes, 0, (int)file.length());
        OutputStream os = response.getOutputStream();
        os.write(bytes);
        os.flush();
        os.close();
    }

    @RequestMapping("/originsAndDests")
    @ResponseBody
    public String getOriginsAndDests() throws Exception{
        Map map = new HashMap();
        map.put("code",1);

        /*// 创建取件地
        //省
        Entity beijing = new Entity(1L,"北京");
        Entity shanghai = new Entity(2L, "上海");
        //市
        Entity beijingCity = new Entity(11L,"北京");
        Entity shanghaiCity = new Entity(12L, "上海");
        //区
        Entity beijingCounty1 = new Entity(111L,"东城区");
        Entity beijingCounty2 = new Entity(112L,"西城区");
        Entity beijingCounty3 = new Entity(113L,"朝阳区");

        Entity shanghaiCounty1 = new Entity(121L,"黄浦区");
        Entity shanghaiCounty2 = new Entity(122L,"徐汇区");
        Entity shanghaiCounty3 = new Entity(123L,"长宁区");

        beijingCity.setChildren(new Entity[]{beijingCounty1,beijingCounty2,beijingCounty3});
        shanghaiCity.setChildren(new Entity[]{shanghaiCounty1,shanghaiCounty2,shanghaiCounty3});

        beijing.setChildren(new Entity[]{beijingCity});
        shanghai.setChildren(new Entity[]{shanghaiCity});
*/
        List<PoiDomesticEntity> poiDomestic = resourceService.buildDomesticPoiEntity();
        map.put("origins", poiDomestic);

        /*//创建国家
        Entity ab = new Entity(-1L,"AB");
        ab.setSelectable(false);
        Entity cd = new Entity(-2L,"CD");
        cd.setSelectable(false);

        ab.setChildren(new Entity[]{
                new Entity(1L,"澳大利亚"),
                new Entity(2L,"奥地利"),
                new Entity(3L,"阿根廷")
        });

        cd.setChildren(new Entity[]{
                new Entity(4L,"加拿大"),
                new Entity(5L,"中国"),
                new Entity(6L,"丹麦")
        });*/

        //FBA目的地
        List<PoiOverseasEntity> poiOverseas = resourceService.buildOverseasPoiEntityByType(1);
        map.put("destinations", poiOverseas);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);
    }


    private class Entity{
        Long id;
        String name;
        Entity[] children;
        boolean selectable = true;

        public Entity() {
        }

        public Entity(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Entity(Long id, String name, Entity[] children) {
            this.id = id;
            this.name = name;
            this.children = children;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Entity[] getChildren() {
            return children;
        }

        public void setChildren(Entity[] children) {
            this.children = children;
        }

        public void setSelectable(boolean selectable) {
            this.selectable = selectable;
        }

    }

}
