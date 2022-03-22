#!/usr/bin/env bash
#
# Example:
#   ./maketable.sh eins zwei
#
#  | Name | Datum |
#  | ------ | ------ |
#  | eins |  |
#  | zwei |  
#
header="| Name | Datum |\n| ------ | ------ |\n";
for i in "$@"; do
  header+="| $i |  |\n";
done

printf "$header"
