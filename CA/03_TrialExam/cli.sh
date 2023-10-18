# projects
#  |--program
#  |   |--.git
#  |   |--assets
#  |   |   |--data.md
#  |   |   |--picture_1.png
#  |   |   └--picture_2.jpg
#  |   └--data.txt
#  └--exam
#      |--data.txt
#      └--images
#          └--picture_3.jpg

# Delete both data.txt
rm program/data.txt exam/data.txt

# Move any type of image files from program/assets/ to exam/images/
mv program/assets/picture_1.png program/assets/picture_2.jpg exam/images/

# Commit the changes
cd program # !!!
git add .
git commit -m "delete txt files and move image files"
