#restaurant
# |--storage
# |   |--.git
# |   |--drygoods.csv
# |   |--vegnfruit.csv
# |   |--chilledprods.csv
# |   └--acount
# |       |--2019-sum.csv
# |       └--2020-sum.csv
# └--delivery
#     |--drivers
#     |   └--john-working-hours.csv
#     |--jessica-working-hours.csv
#     └--account
#         └--2019-sum.csv

# Remove every file from the staging area
cd storage
git reset
cd ..

# Rename storage/acount to storage/account
mv storage/acount storage/account

# Commit the changes
cd storage
git add .
git commit -m 'Rename account'
cd ..

# Change the delivery directory into a Git repository
cd delivery
git init
cd ..

# Move delivery/jessica-working-hours.csv file to delivery/drivers directory
mv delivery/jessica-working-hours.csv delivery/drivers