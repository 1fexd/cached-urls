#!/bin/bash

if [ -z "$1" ]; then
  echo "No database password provided"
  exit 1
fi

password=$1
for table in "resolved_urls" "amp2html_urls"; do
  cmd="COPY (SELECT json_agg(row_to_json($table)) FROM $table)"
  psql -p 5432 -Atx "postgres://postgres.rhxxkicztujvnyntzmmb:$password@aws-0-eu-central-1.pooler.supabase.com:5432/postgres" -c "$cmd TO STDOUT WITH NULL AS ''" >"../src/main/resources/$table.json"
done

python3 update_json.py
python3 write_metadata.py
