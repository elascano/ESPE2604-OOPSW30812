from model.text_file import TextFile
from model.image_file import ImageFile
from model.directory import Directory
from view.client import Client

if __name__ == "__main__":
    readme = TextFile("readme.txt", 2)
    logo = ImageFile("logo.png", 150)
    assets = Directory("assets")
    assets.add(readme)
    assets.add(logo)

    main_code = TextFile("main.py", 8)
    utils_code = TextFile("utils.py", 5)
    src = Directory("src")
    src.add(main_code)
    src.add(utils_code)

    project = Directory("project")
    project.add(assets)
    project.add(src)

    Client.root_item = project
    Client.do_client_tasks()
