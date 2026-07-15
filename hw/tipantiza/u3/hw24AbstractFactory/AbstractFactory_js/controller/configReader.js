const os = require('os');

class ConfigReader {
    
    static getOsType() {
        return ConfigReader.detectOsFromSystem();
    }
    
    static detectOsFromSystem() {
        const platform = os.platform();
        if (platform === 'win32') {
            return 0;
        } else if (platform === 'darwin') {
            return 2;
        } else {
            return 1;
        }
    }
    
    static getOperatingSystemName() {
        const osType = ConfigReader.getOsType();
        if (osType === 0) {
            return "Windows";
        } else if (osType === 2) {
            return "Mac";
        } else {
            return "Linux";
        }
    }
}

module.exports = ConfigReader;