git add .
# - n means not in new line
 echo -n "Commit message: "

 # shellcheck disable=SC2162
 read commit_message

 if [ -z "$commit_message" ]; then
    git commit -m "No message"
    git push -u origin master
 else
   # commit
    git commit -m "$commit_message"
    git push -u origin master
fi