import sys
import os
import subprocess
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent.parent.parent))
from cp_tool.config import PROJECT_ROOT


def print_file_content(file_path: str):
    try:
        with open(file_path, "r") as file:
            content = file.read()
            print(content)
    except FileNotFoundError:
        print(f"File not found: {file_path}")
    except Exception as e:
        print(f"An error occurred: {e}")


def print_output(output: str):
    print("\033[93mOutput:\033[0m")
    print_file_content(output)


def run_program(subfolder: str, lang: str):
    file_name = subfolder + "/Main"
    execute_file = file_name + "." + lang

    # Compile if needed
    if lang == "cpp":
        try:
            command = f"build_cpp {file_name}.cpp"
            result = subprocess.run(command, shell=True)
            if result.returncode != 0:
                return
        except subprocess.CalledProcessError as e:
            print(f"Error running: {e}")
            return

        execute_file = file_name
    elif lang == "java":
        try:
            command = f"build_java {file_name}.java"
            result = subprocess.run(command, shell=True)
            if result.returncode != 0:
                return
        except subprocess.CalledProcessError as e:
            print(f"Error running: {e}")
            return

        execute_file = "java -cp " + subfolder + \
            f":{PROJECT_ROOT}/template" + " Main"

    output_file = os.path.join("temp_output.res")

    try:
        command = f"{execute_file} > {output_file}"
        result = subprocess.run(command, shell=True)
        if result.returncode != 0:
            print(f"Error running: {result.returncode}")
            return
    except subprocess.CalledProcessError as e:
        print(f"Error running: {e}")
        return

    print_output(output_file)


if __name__ == "__main__":
    if len(sys.argv) < 3:
        print("Please specify problem name and language to run")
        sys.exit(1)

    subfolder = sys.argv[1]
    lang = sys.argv[2]
    run_program(subfolder, lang)
