#author Joel Sanchez <The_Softwarriors at ESPE>

# setup.py
from setuptools import setup, find_packages

setup(
    name="taxeslib",
    version="1.0.0",
    author="Joel Sanchez",
    description="Tax calculation library",
    packages=find_packages(),
    python_requires=">=3.6",
)