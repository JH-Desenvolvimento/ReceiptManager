#!/usr/bin/env python3

import subprocess

PROJECT_DIR = "./api/"

subprocess.run(["mvn", "spotless:apply"], cwd=PROJECT_DIR)
