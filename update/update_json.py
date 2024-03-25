import json


def update_file(file_name, input_url, resolved_url):
    with open(file_name, "r") as file:
        _json = json.load(file)

    _dict = {}
    for url in _json:
        _dict[url[input_url]] = url[resolved_url]

    with open(file_name, "w") as file:
        json.dump(_dict, file)


update_file("../src/main/resources/resolved_urls.json", "short_url", "resolved_url")
update_file("../src/main/resources/amp2html_urls.json", "amp_url", "canonical_url")
