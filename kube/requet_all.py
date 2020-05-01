import os
import sys
for i in range(100):
    try:
        os.system("./test_api.sh")
    except KeyboardInterrupt:
        print("KILLING")
        sys.exit()
print("fInIsHeD")



