#/bin/sh
usage() {
    cat <<EOF | 1>&2;
create-simulator.sh [-h] [-n <string>]
    -n  <string> Name of the simulator (default: Pixel_6_API_33_w_Play_Service)
    -h  Print usage
EOF
}

export PATH="$HOME/Library/Android/sdk/tools/bin:$HOME/Library/Android/sdk/emulator:$PATH"
avd_name=Pixel_6_API_33_w_Play_Services

while getopts "n:h" arg; do
  case $arg in
    h)
      usage
      ;;
    n)
      avd_name=$OPTARG
      echo $strength
      ;;
    *)
      usage;;
  esac
done

sdkmanager --install "system-images;android-33;google_apis_playstore;x86_64"
echo "no" | avdmanager --verbose create avd --force --name "$avd_name" --package "system-images;android-33;google_apis_playstore;x86_64"
cp -f ./files/config.ini ~/.android/avd/"$avd_name".avd/config.ini
emulator @"$avd_name"
