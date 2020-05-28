more /Users/mac/Documents/workspace/hello-service/src/main/resources/a.txt | sed -e 's/ //g' | xargs -t -I {} curl http://localhost:8762/test/updateKaide?shopStr={}


more /Users/mac/Documents/workspace/hello-service/src/main/resources/b.txt | sed -e 's/ //g' | xargs -t -I {} curl http://localhost:8762/test/updateKaide?shopStr={}


more /tmp/kaideShops.txt | sed -e 's/ //g' | xargs -t -I {} curl http://localhost:8080/kratos/test/updateKaideShops?shopStr={}

