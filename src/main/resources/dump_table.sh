#!/bin/bash

if [ -z "$1" ]; then
  echo "No database password provided"
  exit 1
fi

password=$1
for table in "resolved_urls" "amp2html_urls"; do
  cmd="COPY (SELECT json_agg(row_to_json($table)) FROM $table)"
  psql -Atx "postgres://postgres:$password@db.rhxxkicztujvnyntzmmb.supabase.co:6543/postgres" -c "$cmd TO STDOUT WITH NULL AS ''" >"$table.json"
done

python3 update_json.py
