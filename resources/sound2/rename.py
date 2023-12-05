import os

# 获取当前文件夹路径
folder_path = os.getcwd()

# 找到所有以.mp3结尾的文件
mp3_files = [file for file in os.listdir(folder_path) if file.endswith(".mp3")]

# 对文件按照指定命名格式重命名
for i, mp3_file in enumerate(mp3_files, start=1):
    new_name = f"music{i}.mp3"
    old_path = os.path.join(folder_path, mp3_file)
    new_path = os.path.join(folder_path, new_name)

    # 重命名文件
    os.rename(old_path, new_path)

    print(f"Renamed: {mp3_file} to {new_name}")
