# !/bin/bash
build_dir="/root/urule"

if [ ! -d $build_dir ]
then
    mkdir -p $build_dir
fi
echo =====================================cp start===============================================
ls -al $build_dir

#rule服务
cp -rf edas-rule-server/target/*.jar $build_dir
#rule客户端
cp -rf edas-rule-client/target/*.jar $build_dir
#执行脚本
cp -rf deploy $build_dir/
chmod 755 -R $build_dir

ls -al $build_dir

echo =====================================cp end===============================================