# 💲电子商务网站设计

## 💙Author

开发者： 狂刄星空

## ✅项目演示地址

http://commerce.krxkgo.top/

### ❗注意事项

由于目前部分浏览器将强制将http协议请求重定向到https请求，而**本次简易系统暂未支持https**（一方面是需要CA证书流程更复杂，而自签名证书又不太适合生产环境，另外就是项目的审核流程问题），故为了运行本项目，建议使用**Edge**浏览器，并访问

```
edge://net-internals/#hsts
```

关闭 

1.  krxkgo.top
2. commerce.krxkgo.top

域名的https安全访问策略即可采用**http**协议访问本项目域名。而对于谷歌浏览器目前似乎并没有很好的解决方案。

<img src="https://github.com/KrxkGit/E-Commerce/blob/main/Pic/1.jpg" alt="image-20231219035939159" style="zoom: 67%;" />

另外，由于服务器性能较弱，可能出现某些性能问题，经实验，后台跑 jar 包服务器内存利用率较高如下图，可能存在性能导致的问题，但由于作为演示项目，考虑暂时维持现状。

<img src="https://github.com/KrxkGit/E-Commerce/blob/main/Pic/2.jpg" alt="image-20231219040002165" style="zoom:80%;" />

## 🟢源码说明

1. frontend 为前端代码，基于Vue3

2. backend 为后端代码，基于Spring Boot。考虑到安全问题，源码中数据库密码已脱敏。

3. documents 包含接口文档，后端接口调试基于ApiFox，同时接口文档已在线发布，地址：

   https://n5y2dzlcej.apifox.cn  访问密码:

   ```tex
   VGvez9PA
   ```

   

4. ```
   e-commerce_init.sql
   ```

   为数据库随机数据初始化脚本，可用于将随机生成的数据迁移到不同平台。

## 🟢测试账户

### 🔵注册新账户

本项目无中心管理员账户，完全由商家与用户账户组成。可自行注册新账户（包括买家用户与商家用户），注意注册账户有如下格式规范：

1. 账户ID为整数，不允许出现非数字。由于目前项目ID号充足，没有ID号强制分配限制，可自行填写喜欢的ID号，只要该ID未被注册即可注册。由于数据库中已经生成了随机的1000个账户，故建议新账户从1001开始。
2. 密码至少6位
3. 注册账户需填写邮箱，目前该邮箱仅保留与数据库，暂未涉及该功能。

### 🔵现存账户

为了更好体现前端效果，演示项目基于Navicat 生成了一些随机数据，供演示使用，该数据不一定符合生产环境逻辑。下列列出50个测试买家用户与商家用户。（由数据库随机生成）

#### 🟣买家账户

| id   | password   | email                    |
| ---- | ---------- | ------------------------ |
| 1    | g3NML7wblV | cly@icloud.com           |
| 2    | N56qarSUI9 | yinchun72@icloud.com     |
| 3    | tbRD7nquRT | ziyim@yahoo.com          |
| 4    | k2OXTBsrXb | houjia@yahoo.com         |
| 5    | kEsSxhuAkd | choyee724@icloud.com     |
| 6    | L635AlPEyQ | maimiyamoto@mail.com     |
| 7    | lRSrrraFJR | tlyi426@icloud.com       |
| 8    | kD5wu2bUlg | akinamar@hotmail.com     |
| 9    | 06eLG6aaOe | yuzhu103@icloud.com      |
| 10   | sksQ60pTCK | hj3@icloud.com           |
| 11   | 2HwtGxm53i | scott1979@gmail.com      |
| 12   | L8H5ho2IHk | lco@outlook.com          |
| 13   | LoEwJdfx70 | yunxqiu@icloud.com       |
| 14   | 17Pt9259Gb | luwu@gmail.com           |
| 15   | wUM4oZ0B0O | waiman02@yahoo.com       |
| 16   | HSP3jo0KQQ | xiaomingwei@yahoo.com    |
| 17   | aM6l7T9yNF | kfhung15@gmail.com       |
| 18   | tMonjupKMG | furu@gmail.com           |
| 19   | DP8FDiBiPr | jacspencer@icloud.com    |
| 20   | cPpvenkcTR | lo1216@gmail.com         |
| 21   | M35EfSjOR4 | laiyan8@gmail.com        |
| 22   | mKkwyXoTfx | chiyuent217@gmail.com    |
| 23   | h9zpVi7WNS | malouise9@outlook.com    |
| 24   | Y8Z25GQde9 | yunxiqiu4@outlook.com    |
| 25   | ZI7yLASdgl | yuitookam@outlook.com    |
| 26   | s5gpJ2YLDX | zhiyzou@gmail.com        |
| 27   | ddmj0lLVRL | zqin@icloud.com          |
| 28   | vfH8D2yw0H | tan3@icloud.com          |
| 29   | jGVpUmGIgl | hou1@gmail.com           |
| 30   | BnTJcPDmaf | chx@mail.com             |
| 31   | f8lMpFRh87 | williams85@icloud.com    |
| 32   | gAQ17ujBMp | rjan@hotmail.com         |
| 33   | ojsER2toRA | grsteph@hotmail.com      |
| 34   | MoHsgmWlF7 | huimei1@hotmail.com      |
| 35   | wMqtCSIrCT | daichii@gmail.com        |
| 36   | 67Owx8mufa | denferg@outlook.com      |
| 37   | 82jqEnixnF | onl60@outlook.com        |
| 38   | Tmgpa2XcHP | eva1213@hotmail.com      |
| 39   | whyyGRw5QR | bruce130@icloud.com      |
| 40   | SxsdGQCo9X | sxiuy@gmail.com          |
| 41   | dGXTDdVpyW | taoxiaoming9@icloud.com  |
| 42   | eoMk6QiVzN | xiuying424@outlook.com   |
| 43   | 2U4XOaED6N | yunxicu91@hotmail.com    |
| 44   | srMNaq9fr0 | hicks9@outlook.com       |
| 45   | WHL6qJPiHk | karencox@gmail.com       |
| 46   | 3TViCu71Fs | xiuyitan9@yahoo.com      |
| 47   | jdBLSFSHMO | sherry1022@gmail.com     |
| 48   | Y16qnaIv9R | yam414@yahoo.com         |
| 49   | AAPLEE4eRr | shirleymendo11@gmail.com |
| 50   | yMIrRiaR8R | yausw90@gmail.com        |



#### 🟣商家账户

| shop_id | password   | email                     |
| ------- | ---------- | ------------------------- |
| 1       | ostHj2togd | durui@icloud.com          |
| 2       | XUM5yjj60Q | matsui1109@hotmail.com    |
| 3       | sPCW7PfJxE | lok86@icloud.com          |
| 4       | v1Ty2cQgKq | wscheng@mail.com          |
| 5       | GTjek6um4Q | nomuhina@mail.com         |
| 6       | vSLHElK4UW | fosterjason2@gmail.com    |
| 7       | EeC7URzIcf | ikkitakad3@icloud.com     |
| 8       | FPILwDP34A | li92@yahoo.com            |
| 9       | XGPZYlA0iu | had95@gmail.com           |
| 10      | QzFJTnbMrj | hina12@icloud.com         |
| 11      | 2EoXw0I1Tz | wangrui526@gmail.com      |
| 12      | PieYcrSSrL | schristina@hotmail.com    |
| 13      | O6YkT2Dazd | facw06@mail.com           |
| 14      | rIx9oiLqqL | sugiyamat6@gmail.com      |
| 15      | tuaIew7cMy | mit82@gmail.com           |
| 16      | 2G1HUOCyzA | nakagawa331@hotmail.com   |
| 17      | Aa8FVEHzCA | roberhunt@hotmail.com     |
| 18      | 0YRf01IVmF | sukyeec@gmail.com         |
| 19      | EjVyykPPzL | mioshib@outlook.com       |
| 20      | BFwiUuMC2S | uchidamomo@icloud.com     |
| 21      | PhQTHcXpsf | menghiutung06@hotmail.com |
| 22      | 8jhkg4Nemb | judith8@gmail.com         |
| 23      | JKvsVglrkt | gotokasumi@gmail.com      |
| 24      | pF04crrPHO | lychia2@outlook.com       |
| 25      | nIpDkl5PeG | haoyu125@icloud.com       |
| 26      | zjeHZQl6v4 | ma7@gmail.com             |
| 27      | f3fTSumrB1 | hys914@mail.com           |
| 28      | 83xazxxx9L | takwahs@mail.com          |
| 29      | eeF7bP35cA | hlan05@outlook.com        |
| 30      | SsUEwqBjcY | chiykwong@icloud.com      |
| 31      | 0Mm8WQWddz | graymaria103@gmail.com    |
| 32      | oSR5BlWmDk | frguzman@outlook.com      |
| 33      | Q410uGjsw7 | caijialun9@yahoo.com      |
| 34      | fUZtf0spcX | tkw@icloud.com            |
| 35      | yXG9rA6Gzn | harai@icloud.com          |
| 36      | N5qahb2SVa | lu8@icloud.com            |
| 37      | 1cozZHg21t | xuzi9@hotmail.com         |
| 38      | agzNTpPZmg | price1@outlook.com        |
| 39      | ratQaJ8h8X | ren1119@hotmail.com       |
| 40      | sbl2D9MKd6 | jaherrera54@gmail.com     |
| 41      | LHI8CEf465 | moralesgl87@icloud.com    |
| 42      | nrFmxdoS0N | wfchoi2011@mail.com       |
| 43      | pNd3RC3oJw | zch@mail.com              |
| 44      | gpPZx1ReW2 | albc@gmail.com            |
| 45      | p3qdrBwnkU | ishiikki@yahoo.com        |
| 46      | 94TvovI3JL | crjes10@hotmail.com       |
| 47      | KcP62i3zMk | ku81@yahoo.com            |
| 48      | MMsQlYmKgv | lisasimpson89@gmail.com   |
| 49      | ROJw0DT4zN | nig7@outlook.com          |
| 50      | irZALEZGgA | tsangliksun@yahoo.com     |

