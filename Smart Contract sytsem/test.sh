# #!/bin/sh

# clear

# echo "Starting Network"
# npm run env:restart

# echo "Deploying Property Chaincode"
# npm run cc:start -- property

# #sleep 20

# echo "=== Invoking Transactions === "
# echo "    "
echo "--- Creating Participants ---"
hurl invoke property participant_register admin "Administrator" -u admin
hurl invoke property participant_register user1 "User 1" -u user1

echo " "
echo "--- Invoking Property Chaincode ---"
hurl invoke property property_createProperty 0001 "Villa" user1 200 false -u user1

hurl invoke property property_createProperty 0002 "Apartment"  admin 100 true -u admin

hurl invoke property participant_get admin

hurl invoke property participant_get user1

hurl invoke property property_updateForSale 0001  true 

hurl invoke property property_transferProperty 0001 admin

hurl invoke property property_getProperty 0002 