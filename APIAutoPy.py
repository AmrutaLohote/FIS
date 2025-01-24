import requests

url = "https://api.coindesk.com/v1/bpi/currentprice.json"
response = requests.get(url)

if response.status_code != 200:
    raise Exception(f"Request failed with status code: {response.status_code}")

data = response.json()

bpis = data["bpi"]
if len(bpis) != 3:
    raise Exception("Expected 3 BPIs, found: {}".format(len(bpis)))

if "USD" not in bpis or "GBP" not in bpis or "EUR" not in bpis:
    raise Exception("Missing one or more of the expected BPIs.")

if bpis["GBP"]["description"] != "British Pound Sterling":
    raise Exception("GBP description is incorrect.")

print("Verification successful!")